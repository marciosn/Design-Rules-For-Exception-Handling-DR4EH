package br.ufc.quixada.dr4eh;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.designwizard.design.ClassNode;
import org.designwizard.design.MethodNode;
import org.designwizard.exception.InexistentEntityException;
import org.designwizard.main.DesignWizard;

import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;

/*
 * https://github.com/marciosn/DesignRulesForExceptionHandling.git
 */
public class EHDesignWizard {

	private DesignWizard designWizard;

	public static void main(String[] args) throws IOException {
		EHDesignWizard ehdw = new EHDesignWizard("lib" + File.separator + "iContatos.jar");

		Module module = new Module();
		Module module2 = new Module();
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		// module.add(ContatoDAO.class);

		// if (ehdw.canOnlySignal(module, CTLException.class)) {
		// if (ehdw.onlyCanSignal(module, DAOException.class, module2)) {
		// if (ehdw.cannotSignal(module, DAOException.class)) {
		 if (ehdw.mustSignal(module, CTLException.class)) {

		// if (ehdw.canOnlyHandle(module, DAOException.class)) {
		// if (ehdw.onlyCanHandle(module, DAOException.class)) {
		// if (ehdw.cannotHandle(module, DAOException.class)) {
		// if (ehdw.mustHandle(module, DAOException.class)) {

		// if (ehdw.canOnlyRaise(module, CTLException.class)) {
		// if (ehdw.OnlycanRaise(module, CTLException.class)) {
		// if (ehdw.cannotRaise(module, CTLException.class)) {
		// if (ehdw.mustRaise(module, DAOException.class)) {
			System.out.println("Verdade!");
		} else {
			System.out.println("Falso!");
		}
	}

	public EHDesignWizard(String appJarPath) {
		try {
			designWizard = new DesignWizard(appJarPath);
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	/*
	 * ********************************************************************************************
	 * ****************************************RULES SIGNAL****************************************
	 * ********************************************************************************************
	 */
	public boolean canOnlySignal(Module module, Class<?> exception) {
		boolean canOnlySignal = false;
		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}
		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}

		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				Set<ClassNode> e = method.getThrownExceptions();
				if (e.size() > 1) {
					return false;
				}
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					canOnlySignal = true;
				}
			}
		}

		return canOnlySignal;
	}

	public boolean onlyCanSignal(Module module, Class<?> exception) {
		boolean onlyCanSignal = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}
		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : allClassNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					onlyCanSignal = false;
				}
			}

		}
		return onlyCanSignal;
	}

	public boolean cannotSignal(Module module, Class<?> exception) {
		boolean cannotSignal = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				Set<ClassNode> e = method.getThrownExceptions();
				
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					cannotSignal = false;
				}
			}

		}

		return cannotSignal;
	}

	public boolean mustSignal(Module module, Class<?> exception) {
		boolean mustSignal = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		int count = 0;
		int quantidade = 0;
		for(ClassNode n : classNodes){
			Set<MethodNode> m = n.getAllMethods();
			quantidade = m.size();
			for (MethodNode meth : m) {
				if(meth.getShortName().equals("<init>()")){
					count++;
				}
			}
			System.out.println("Quantidade "+quantidade);
			System.out.println("Numero de metodos sem throws "+count);
		}
		if(count == quantidade)
			System.out.println("IGUAL");
		
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				//System.out.println("Quantidade de execeções sinalizadas = "+method.getThrownExceptions().size());
				//System.out.println("Nome do Metodo = "+method.getShortName());
				//System.out.println("Tipo = "+method.getReturnType());
				if(!method.getShortName().equals("<init>()")){
					//System.out.println("É Igual");
					if (!method.getThrownExceptions().contains(exceptionClassNode)) {
						mustSignal = false;
					}
				}
			}
		}
		return mustSignal;
	}

	/*
	 * ********************************************************************************************
	 * ****************************************RULES HANDLE****************************************
	 * ********************************************************************************************
	 */

	public boolean canOnlyHandle(Module module, Class<?> exception) {
		boolean canOnlyHandle = false;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				Set<ClassNode> e = method.getCatchedExceptions();
				if (e.size() > 1) {
					return false;
				}
				if (method.getCatchedExceptions().contains(exceptionClassNode)) {
					canOnlyHandle = true;
				}
			}
		}
		return canOnlyHandle;
	}

	public boolean onlyCanHandle(Module module, Class<?> exception) {
		boolean onlyCanHandle = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : allClassNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getCatchedExceptions().contains(exceptionClassNode)) { 
					onlyCanHandle = false;
				}
			}
		}
		return onlyCanHandle;
	}

	public boolean cannotHandle(Module module, Class<?> exception) {
		boolean cannotHandle = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getCatchedExceptions().contains(exceptionClassNode)) {
					cannotHandle = false;
				}
			}
		}
		return cannotHandle;
	}

	public boolean mustHandle(Module module, Class<?> exception) {
		boolean mustHandle = false;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getCatchedExceptions().contains(exceptionClassNode)) {
					mustHandle = true;
				}
			}

		}

		return mustHandle;
	}

	/*
	 * ********************************************************************************************
	 * ****************************************RULES RAISE*****************************************
	 * ********************************************************************************************
	 */
	public boolean canOnlyRaise(Module module, Class<?> exception) {
		boolean canOnlyRaise = false;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}
		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				Set<ClassNode> e = method.getThrownExceptions();
				/*if (e.size() > 1)
					return false;*/
				if (method.getThrownExceptions().contains(exceptionClassNode) && !(method.getCatchedExceptions().contains(exceptionClassNode))) {
					canOnlyRaise = true;
				}
			}
		}
		return canOnlyRaise;
	}

	public boolean onlyCanRaise(Module module, Class<?> exception) {
		boolean onlyCanRaise = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}
		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : allClassNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode) && !(method.getCatchedExceptions().contains(exceptionClassNode))) {
					onlyCanRaise = false;
				}
			}

		}

		return onlyCanRaise;
	}

	public boolean mustRaise(Module module, Class<?> exception) {
		boolean mustRaise = false;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode) && !(method.getCatchedExceptions().contains(exceptionClassNode))) {
					mustRaise = true;
				}
			}
		}
		return mustRaise;
	}

	public boolean cannotRaise(Module module, Class<?> exception) {
		boolean cannotRaise = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode) && !(method.getCatchedExceptions().contains(exceptionClassNode))) {
					cannotRaise = false;
				}
			}

		}

		return cannotRaise;
	}
	/*
	 * ********************************************************************************************
	 * ****************************************RULES M TO N****************************************
	 * ********************************************************************************************
	 */
	public boolean onlyCanSignal(Module signalModule, Class<?> exception, Module handlerModule) { // FUNCIONANDO
		boolean onlyCanSignal = false;

		if (onlyCanSignal(signalModule, exception)) {
			Set<ClassNode> handleClassNodes = new HashSet<ClassNode>();
			if (signalModule.hasClassTypes()) {
				handleClassNodes.addAll(convertClassTypesToClassNodes(handlerModule.getClassTypes()));
			}

			if (signalModule.hasPackageNames()) {
				handleClassNodes.addAll(convertPackageNamesToClassNodes(handlerModule.getPackageNames()));
			}

			ClassNode exceptionClassNode;
			try {
				exceptionClassNode = designWizard.getClass(exception);
			} catch (InexistentEntityException iee) {
				throw new RuntimeException(iee);
			}

			for (ClassNode node : handleClassNodes) {
				Set<MethodNode> methods = node.getAllMethods();
				for (MethodNode method : methods) {
					if (method.getCatchedExceptions().contains(exceptionClassNode)) {
						onlyCanSignal = true;
					}
				}
			}
		}
		return onlyCanSignal;

	}
	public boolean canOnlySignal(Module signalModule, Class<?> exception, Module handlerModule) {
		boolean canOnlySignal = true;
		Set<ClassNode> signalClassNodes = new HashSet<ClassNode>();
		if (signalModule.hasClassTypes()) {
			signalClassNodes.addAll(convertClassTypesToClassNodes(signalModule.getClassTypes()));
		}
		if (signalModule.hasPackageNames()) {
			signalClassNodes.addAll(convertPackageNamesToClassNodes(signalModule.getPackageNames()));
		}
		Set<ClassNode> handleClassNodes = new HashSet<ClassNode>();
		if (signalModule.hasClassTypes()) {
			handleClassNodes.addAll(convertClassTypesToClassNodes(handlerModule.getClassTypes()));
		}

		if (signalModule.hasPackageNames()) {
			handleClassNodes.addAll(convertPackageNamesToClassNodes(handlerModule.getPackageNames()));
		}

		ClassNode exceptionClassNode;
		try {
			exceptionClassNode = designWizard.getClass(exception);
		} catch (InexistentEntityException iee) {
			throw new RuntimeException(iee);
		}

		Set<MethodNode> calleeMethodNodes = new HashSet<MethodNode>();

		Set<MethodNode> signalMethodNodes = new HashSet<MethodNode>();
					
		for (ClassNode calleeClassNode : handleClassNodes) {
			calleeMethodNodes.addAll(calleeClassNode.getCalleeMethods());
			//System.out.println(calleeClassNode.getCalleeMethods());
		}

		for (MethodNode calleeMethodNode : calleeMethodNodes) {
			if (signalClassNodes.contains(calleeMethodNode.getClassNode())) {
				signalMethodNodes.add(calleeMethodNode);
				//System.out.println("Classe Pertencente "+ calleeMethodNode.getClassNode());
				//System.out.println("Metodo que Handle Chama em Signal = "+calleeMethodNode);
				System.out.println("Quantidade de Metodos Chamados = "+signalMethodNodes.size());
			}
		}
		for (MethodNode signalMethodNode : signalMethodNodes) {
			//System.out.println("Nome do metodo que deve sinalizar exceção = "+signalMethodNode.getName());
			//System.out.println("Quantidade Sinalizada pelo metodo = "+ signalMethodNode.getThrownExceptions().size());

			if (!((signalMethodNode.getThrownExceptions().size() == 1)&&(signalMethodNode.getThrownExceptions().contains(exceptionClassNode)))) {
			//if ((signalMethodNode.getThrownExceptions().size() == 0)) {
				System.out.println("O tamanho é 0");
				return false;
				//canOnlySignal = false;
			}else
				System.out.println("O tamanho é maior que 0");
		}
		return canOnlySignal;
	}
	public boolean cannotSignal(Module signalModule, Class<?> exception, Module handlerModule) { // FUNCIONANDO
		boolean cannotSignal = true;

		if (!cannotSignal(signalModule, exception)) {
			Set<ClassNode> handleClassNodes = new HashSet<ClassNode>();
			if (signalModule.hasClassTypes()) {
				handleClassNodes.addAll(convertClassTypesToClassNodes(handlerModule.getClassTypes()));
			}

			if (signalModule.hasPackageNames()) {
				handleClassNodes.addAll(convertPackageNamesToClassNodes(handlerModule.getPackageNames()));
			}

			ClassNode exceptionClassNode;
			try {
				exceptionClassNode = designWizard.getClass(exception);
			} catch (InexistentEntityException iee) {
				throw new RuntimeException(iee);
			}

			for (ClassNode node : handleClassNodes) {
				Set<MethodNode> methods = node.getAllMethods();
				for (MethodNode method : methods) {
					if (method.getCatchedExceptions().contains(exceptionClassNode)) {
						cannotSignal = false;
					}
				}
			}
		}
		return cannotSignal;

	}
	public boolean mustSignal(Module signalModule, Class<?> exception, Module handlerModule) {
		boolean mustSignal = true;

		if (mustSignal(signalModule, exception)) {
			Set<ClassNode> handleClassNodes = new HashSet<ClassNode>();
			if (signalModule.hasClassTypes()) {
				handleClassNodes.addAll(convertClassTypesToClassNodes(handlerModule.getClassTypes()));
			}

			if (signalModule.hasPackageNames()) {
				handleClassNodes.addAll(convertPackageNamesToClassNodes(handlerModule.getPackageNames()));
			}

			ClassNode exceptionClassNode;
			try {
				exceptionClassNode = designWizard.getClass(exception);
			} catch (InexistentEntityException iee) {
				throw new RuntimeException(iee);
			}

			for (ClassNode node : handleClassNodes) {
				Set<MethodNode> methods = node.getAllMethods();
				for (MethodNode method : methods) {
					if (!(method.getCatchedExceptions().contains(exceptionClassNode))) {
						mustSignal = false;
					}
				}
			}
		}
		return mustSignal;

	}
	private Set<ClassNode> convertClassTypesToClassNodes(Set<Class<?>> classTypes) {
		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		for (Class<?> classType : classTypes) {
			try {
				classNodes.add(designWizard.getClass(classType));
			} catch (InexistentEntityException iee) {
				throw new RuntimeException(iee);
			}
		}
		return classNodes;
	}

	private Set<ClassNode> convertPackageNamesToClassNodes(Set<String> packageNames) {
		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		for (String packageName : packageNames) {
			try {
				classNodes.addAll(designWizard.getPackage(packageName).getAllClasses());
			} catch (InexistentEntityException iee) {
				throw new RuntimeException(iee);
			}
		}
		return classNodes;
	}
}
