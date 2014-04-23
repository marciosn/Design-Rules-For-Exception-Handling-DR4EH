package br.ufc.quixada.dr4eh;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.designwizard.design.ClassNode;
import org.designwizard.design.MethodNode;
import org.designwizard.exception.InexistentEntityException;
import org.designwizard.main.DesignWizard;

import br.ufc.quixada.control.Controller;
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
		//module.add(Controller.class);

		//if (ehdw.canOnlySignal(module, CTLException.class)) {
		if (ehdw.canSignal(module, CTLException.class)) {
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

	public boolean canOnlySignal(Module module, Class<?> exception) {
		boolean canOnlySignal = true;

		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}
		
		Set<ClassNode> allClassNodes = designWizard.getAllClasses();
		allClassNodes.removeAll(classNodes);
		//System.out.println(classNodes);
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
					canOnlySignal = false;
				}
			}
		}

		return canOnlySignal;
	}
	public boolean canSignal(Module module, Class<?> exception){
		boolean canSignal = true;
		
		Set<ClassNode> classNodes = new HashSet<ClassNode>();
		if (module.hasClassTypes()) {
			classNodes.addAll(convertClassTypesToClassNodes(module.getClassTypes()));
		}

		if (module.hasPackageNames()) {
			classNodes.addAll(convertPackageNamesToClassNodes(module.getPackageNames()));
		}

		System.out.println("Class Node Name " + classNodes);
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
				if (method.getThrownExceptions().contains(exceptionClassNode) && method.getPackage()!= classNodes) {
					canSignal = false;
				}
			}
			
		}
		
		return canSignal;
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
