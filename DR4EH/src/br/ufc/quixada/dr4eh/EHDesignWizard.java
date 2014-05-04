package br.ufc.quixada.dr4eh;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
		module.add("br.ufc.quixada.control");
		//module.add(ContatoDAO.class);

		//if (ehdw.canOnlySignal(module, CTLException.class)) {
		//if (ehdw.OnlycanSignal(module, DAOException.class)) {
		//if (ehdw.cannotSignal(module, DAOException.class)) {
		//if (ehdw.mustSignal(module, DAOException.class)) {
		
		//if (ehdw.canOnlyHandle(module, CTLException.class)) {
		//if (ehdw.OnlycanHandle(module, CTLException.class)) {
		//if (ehdw.cannotHandle(module, DAOException.class)) {
		//if (ehdw.mustHandle(module, CTLException.class)) {
			
		//if (ehdw.canOnlyRaise(module, CTLException.class)) {
		//if (ehdw.OnlycanRaise(module, DAOException.class)) {
		//if (ehdw.cannotRaise(module, CTLException.class)) {
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
			for (MethodNode method : methods){
				Set<ClassNode> e = method.getThrownExceptions();
				if(e.size() > 1){
					return false;
				}
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					canOnlySignal = true;			
				}
			}
		}

		return canOnlySignal;
	}
	
	public boolean OnlycanSignal(Module module, Class<?> exception){
		boolean OnlycanSignal = true;
		
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
		for(ClassNode node: allClassNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					OnlycanSignal = false;
				}
			}
			
		}
		
		return OnlycanSignal;
	}
	
	public boolean cannotSignal(Module module, Class<?> exception){
		boolean cannotSignal = true;
		
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
		for(ClassNode node: classNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					cannotSignal = false;
				}
			}
			
		}
		
		return cannotSignal;
	}	
	public boolean mustSignal(Module module, Class<?> exception){
		boolean mustSignal = false;
		
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
		for(ClassNode node: classNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode)) {
					mustSignal = true;
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
	
	public boolean canOnlyHandle(Module module, Class<?> exception){
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
				if(e.size() > 1){
					return false;
				}
				if (method.getCatchedExceptions().contains(exceptionClassNode)) {
					canOnlyHandle = true;
				}
			}
		}
		
		return canOnlyHandle;
	}	
	public boolean OnlycanHandle(Module module, Class<?> exception){
		boolean OnlycanHandle = true;
		
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
		for(ClassNode node: allClassNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getCatchedExceptions().contains(exceptionClassNode)) { //&& method.getPackage()!= classNodes
					OnlycanHandle = false;
				}
			}
			
		}
		
		return OnlycanHandle;
	}
	
	public boolean cannotHandle(Module module, Class<?> exception){
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
		for(ClassNode node: classNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getCatchedExceptions().contains(exceptionClassNode)) {
					cannotHandle = false;
				}
			}
			
		}
		
		return cannotHandle;
	}
	
	public boolean mustHandle(Module module, Class<?> exception){
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
		for(ClassNode node: classNodes){
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
			for (MethodNode method : methods){
				Set<ClassNode> e = method.getThrownExceptions();
				if(e.size() > 1)
					return false;
				if (method.getThrownExceptions().contains(exceptionClassNode)
						&& (method.getCatchedExceptions().contains(exceptionClassNode))== false) {
					canOnlyRaise = true;
				}
			}
		}
		return canOnlyRaise;
	}
	public boolean OnlycanRaise(Module module, Class<?> exception){
		boolean OnlycanRaise = true;
		
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
		for(ClassNode node: allClassNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if (method.getThrownExceptions().contains(exceptionClassNode)
						&& (method.getCatchedExceptions().contains(exceptionClassNode))== false) {
					OnlycanRaise = false;
				}
			}
			
		}
		
		return OnlycanRaise;
	}
	public boolean mustRaise(Module module, Class<?> exception){
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
		for(ClassNode node: classNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if(method.getThrownExceptions().contains(exceptionClassNode)
						&& (method.getCatchedExceptions().contains(exceptionClassNode))== false){			
						mustRaise = true;
				}
			}
		}
		return mustRaise;
	}
	public boolean cannotRaise(Module module, Class<?> exception){
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
		for(ClassNode node: classNodes){
			Set<MethodNode> methods = node.getAllMethods();
			for (MethodNode method : methods) {
				if(method.getThrownExceptions().contains(exceptionClassNode)
						&& (method.getCatchedExceptions().contains(exceptionClassNode))== false){			
						cannotRaise = false;
				}
			}
			
		}
		
		return cannotRaise;
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
