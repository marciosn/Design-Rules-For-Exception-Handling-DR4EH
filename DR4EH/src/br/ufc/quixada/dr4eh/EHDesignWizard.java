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

/*
 * https://github.com/marciosn/DesignRulesForExceptionHandling.git
 */
public class EHDesignWizard {

	private DesignWizard designWizard;

	public static void main(String[] args) throws IOException {
		EHDesignWizard ehdw = new EHDesignWizard("lib" + File.separator + "iContatos.jar");

		Module module = new Module();
		module.add("br.ufc.quixada.control");
		// module.add(ContatoDAO.class);

		// if (ehdw.canOnlySignal(module, DAOException.class)) {
		// if (ehdw.OnlycanSignal(module, CTLException.class)) {
		// if (ehdw.cannotSignal(module, DAOException.class)) {
		// if (ehdw.mustSignal(module, CTLException.class)) {

		// if (ehdw.canOnlyHandle(module, CTLException.class)) {
		// if (ehdw.OnlycanHandle(module, CTLException.class)) {
		// if (ehdw.cannotHandle(module, DAOException.class)) {
		// if (ehdw.mustHandle(module, CTLException.class)) {

		// if (ehdw.canOnlyRaise(module, CTLException.class)) {
		// if (ehdw.OnlycanRaise(module, CTLException.class)) {
		// if (ehdw.cannotRaise(module, DAOException.class)) {
		if (ehdw.mustRaise(module, CTLException.class)) {
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
		for (ClassNode node : classNodes) {
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (!method.getThrownExceptions().contains(exceptionClassNode)) {
					mustSignal = false;
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
				if (method.getCatchedExceptions().contains(exceptionClassNode)) { // &&
																					// method.getPackage()!=
																					// classNodes
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
				if (e.size() > 1)
					return false;
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

	public boolean onlyCanSignal(Module signalModule, Class<?> exception, Module handlerModule) {
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
		}

		for (MethodNode calleeMethodNode : calleeMethodNodes) {
			if (signalClassNodes.contains(calleeMethodNode.getClassNode())) {
				signalMethodNodes.add(calleeMethodNode);
			}
		}

		for (MethodNode signalMethodNode : signalMethodNodes) {
			if (!(signalMethodNode.getThrownExceptions().size() == 1 && signalMethodNode.getThrownExceptions().contains(exceptionClassNode))) {
				return false;
			}
		}

		return true;
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
