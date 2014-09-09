package br.ufc.quixada.dr4eh.test;

import java.io.File;

import br.ufc.quixada.dr4eh.DR4EH;
import br.ufc.quixada.dr4eh.Module;
import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;
import junit.framework.TestCase;

public class JUnitTestAllRules extends TestCase{
	DR4EH dw = new DR4EH("lib" + File.separator + "iContatos.jar");
	private Module module = new Module();
	private Module module2 = new Module();
	
	/********************************************************************************
	 *						 RULES CAN ONLY SIGNAL
	 ********************************************************************************
	 */
	public void testcanOnlySignal_Control_DAO_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Control_CTL_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Control_DAO_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Control_CTL_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Control_DAO_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Control_CTL_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Control_DAO_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Control_CTL_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcanOnlySignal_DAO_DAO_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_DAO_CTL_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_DAO_DAO_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_DAO_CTL_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_DAO_DAO_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_DAO_CTL_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_DAO_DAO_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_DAO_CTL_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcanOnlySignal_Model_DAO_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Model_CTL_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Model_DAO_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Model_CTL_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Model_DAO_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Model_CTL_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Model_DAO_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Model_CTL_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcanOnlySignal_View_DAO_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_View_CTL_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_View_DAO_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_View_CTL_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_View_DAO_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_View_CTL_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_View_DAO_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_View_CTL_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcanOnlySignal_Exception_DAO_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Exception_CTL_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Exception_DAO_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Exception_CTL_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Exception_DAO_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Exception_CTL_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	public void testcanOnlySignal_Exception_DAO_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Exception_CTL_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, CTLException.class, module2));
	}
	
	/********************************************************************************
	 *						 RULES ONLY	CAN SIGNAL
	 ********************************************************************************
	 */
	public void testonlycanSignal_Control_DAO_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Control_CTL_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Control_DAO_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Control_CTL_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Control_DAO_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Control_CTL_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Control_DAO_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Control_CTL_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testonlycanSignal_DAO_DAO_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_DAO_CTL_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_DAO_DAO_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_DAO_CTL_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_DAO_DAO_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_DAO_CTL_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_DAO_DAO_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_DAO_CTL_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testonlycanSignal_Model_DAO_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Model_CTL_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Model_DAO_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Model_CTL_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Model_DAO_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Model_CTL_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Model_DAO_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Model_CTL_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testonlycanSignal_View_DAO_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_View_CTL_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_View_DAO_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_View_CTL_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_View_DAO_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_View_CTL_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_View_DAO_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_View_CTL_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testonlycanSignal_Exception_DAO_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Exception_CTL_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Exception_DAO_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Exception_CTL_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Exception_DAO_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Exception_CTL_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	public void testonlycanSignal_Exception_DAO_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class, module2));
	}
	public void testonlycanSignal_Exception_CTL_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, CTLException.class, module2));
	}
	/********************************************************************************
	 *						 RULES MUST SIGNAL
	 ********************************************************************************
	 */
	public void testmustSignal_Control_DAO_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Control_CTL_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Control_DAO_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Control_CTL_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Control_DAO_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Control_CTL_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Control_DAO_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Control_CTL_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testmustSignal_DAO_DAO_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_DAO_CTL_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_DAO_DAO_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_DAO_CTL_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_DAO_DAO_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_DAO_CTL_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_DAO_DAO_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_DAO_CTL_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testmustSignal_Model_DAO_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Model_CTL_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Model_DAO_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Model_CTL_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Model_DAO_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Model_CTL_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Model_DAO_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Model_CTL_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testmustSignal_View_DAO_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_View_CTL_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_View_DAO_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_View_CTL_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_View_DAO_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_View_CTL_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_View_DAO_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_View_CTL_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testmustSignal_Exception_DAO_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Exception_CTL_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Exception_DAO_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Exception_CTL_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Exception_DAO_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Exception_CTL_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	public void testmustSignal_Exception_DAO_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class, module2));
	}
	public void testmustSignal_Exception_CTL_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class, module2));
	}
	/********************************************************************************
	 *						 RULES CANNOT SIGNAL
	 ********************************************************************************
	 */
	public void testcannotSignal_Control_DAO_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Control_CTL_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Control_DAO_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Control_CTL_Model(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Control_DAO_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Control_CTL_View(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.view");
		assertFalse(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Control_DAO_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Control_CTL_Exception(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcannotSignal_DAO_DAO_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_DAO_CTL_Control(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_DAO_DAO_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertFalse(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_DAO_CTL_Model(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_DAO_DAO_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_DAO_CTL_View(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_DAO_DAO_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_DAO_CTL_Exception(){
		module.add("br.ufc.quixada.dao");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcannotSignal_Model_DAO_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Model_CTL_Control(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Model_DAO_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Model_CTL_DAO(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Model_DAO_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Model_CTL_View(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Model_DAO_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Model_CTL_Exception(){
		module.add("br.ufc.quixada.model");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcannotSignal_View_DAO_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_View_CTL_Control(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_View_DAO_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_View_CTL_DAO(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_View_DAO_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_View_CTL_Model(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_View_DAO_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_View_CTL_Exception(){
		module.add("br.ufc.quixada.view");
		module2.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	/*
	 * ************************************************************************
	 */
	public void testcannotSignal_Exception_DAO_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Exception_CTL_Control(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Exception_DAO_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Exception_CTL_DAO(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Exception_DAO_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Exception_CTL_Model(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	public void testcannotSignal_Exception_DAO_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, DAOException.class, module2));
	}
	public void testcannotSignal_Exception_CTL_View(){
		module.add("br.ufc.quixada.exception");
		module2.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, CTLException.class, module2));
	}
	/********************************************************************************
	 *						 RULES CAN ONLY HANDLE
	 ********************************************************************************
	 */
	public void testcanOnlyHandle_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testcanOnlyHandle_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlyHandle(module, CTLException.class));
	}
	public void testcanOnlyHandle_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testcanOnlyHandle_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlyHandle(module, CTLException.class));
	}
	public void testcanOnlyHandle_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testcanOnlyHandle_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyHandle(module, CTLException.class));
	}
	public void testcanOnlyHandle_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testcanOnlyHandle_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.canOnlyHandle(module, CTLException.class));
	}
	public void testcanOnlyHandle_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testcanOnlyHandle_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyHandle(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES ONLY CAN HANDLE
	 ********************************************************************************
	 */
	public void testOnlycanHandle_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlyHandle(module, DAOException.class));
	}
	public void testOnlycanHandle_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanHandle(module, CTLException.class));
	}
	public void testOnlycanHandle_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanHandle(module, DAOException.class));
	}
	public void testOnlycanHandle_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanHandle(module, CTLException.class));
	}
	public void testOnlycanHandle_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanHandle(module, DAOException.class));
	}
	public void testOnlycanHandle_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanHandle(module, CTLException.class));
	}
	public void testOnlycanHandle_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanHandle(module, DAOException.class));
	}
	public void testOnlycanHandle_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.onlyCanHandle(module, CTLException.class));
	}
	public void testOnlycanHandle_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanHandle(module, DAOException.class));
	}
	public void testOnlycanHandle_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanHandle(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES CANNOT HANDLE
	 ********************************************************************************
	 */
	public void testcannotHandle_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.cannotHandle(module, DAOException.class));
	}
	public void testcannotHandle_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.cannotHandle(module, CTLException.class));
	}
	public void testcannotHandle_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotHandle(module, DAOException.class));
	}
	public void testcannotHandle_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotHandle(module, CTLException.class));
	}
	public void testcannotHandle_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotHandle(module, DAOException.class));
	}
	public void testcannotHandle_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotHandle(module, CTLException.class));
	}
	public void testcannotHandle_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.cannotHandle(module, DAOException.class));
	}
	public void testcannotHandle_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.cannotHandle(module, CTLException.class));
	}
	public void testcannotHandle_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotHandle(module, DAOException.class));
	}
	public void testcannotHandle_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotHandle(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES MUST HANDLE
	 ********************************************************************************
	 */
	public void testmustHandle_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.mustHandle(module, DAOException.class));
	}
	public void testmustHandle_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.mustHandle(module, CTLException.class));
	}
	public void testmustHandle_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.mustHandle(module, DAOException.class));
	}
	public void testmustHandle_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.mustHandle(module, CTLException.class));
	}
	public void testmustHandle_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustHandle(module, DAOException.class));
	}
	public void testmustHandle_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustHandle(module, CTLException.class));
	}
	public void testmustHandle_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.mustHandle(module, DAOException.class));
	}
	public void testmustHandle_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.mustHandle(module, CTLException.class));
	}
	public void testmustHandle_Excepion_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustHandle(module, DAOException.class));
	}
	public void testmustHandle_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustHandle(module, CTLException.class));
	}
	public void testcanOnlyRaise_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testcanOnlyRaise_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testcanOnlyRaise_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testcanOnlyRaise_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testcanOnlyRaise_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testcanOnlyRaise_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testcanOnlyRaise_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testcanOnlyRaise_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testcanOnlyRaise_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testcanOnlyRaise_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES ONLY CAN RAISE
	 ********************************************************************************
	 */
	public void testOnlycanRaise_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.onlyCanRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.onlyCanRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanRaise(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES CANNOT RAISE
	 ********************************************************************************
	 */
	public void testcannotRaise_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.cannotRaise(module, DAOException.class));
	}
	public void testcannotRaise_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.cannotRaise(module, CTLException.class));
	}
	public void testcannotRaise_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.cannotRaise(module, DAOException.class));
	}
	public void testcannotRaise_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotRaise(module, CTLException.class));
	}
	public void testcannotRaise_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotRaise(module, DAOException.class));
	}
	public void testcannotRaise_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotRaise(module, CTLException.class));
	}
	public void testcannotRaise_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.cannotRaise(module, DAOException.class));
	}
	public void testcannotRaise_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.cannotRaise(module, CTLException.class));
	}
	public void testcannotRaise_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotRaise(module, DAOException.class));
	}
	public void testcannotRaise_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotRaise(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES MUST RAISE
	 ********************************************************************************
	 */
	public void testmustRaise_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.mustRaise(module, DAOException.class));
	}
	public void testmustRaise_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.mustRaise(module, CTLException.class));
	}
	public void testmustRaise_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.mustRaise(module, DAOException.class));
	}
	public void testmustRaise_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.mustRaise(module, CTLException.class));
	}
	public void testmustRaise_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustRaise(module, DAOException.class));
	}
	public void testmustRaise_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustRaise(module, CTLException.class));
	}
	public void testmustRaise_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.mustRaise(module, DAOException.class));
	}
	public void testmustRaise_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.mustRaise(module, CTLException.class));
	}
	public void testmustRaise_Excepion_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustRaise(module, DAOException.class));
	}
	public void testmustRaise_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustRaise(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES CAN ONLY SIGNAL
	 ********************************************************************************
	 */
	public void testcanOnlySignal_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlySignal(module, DAOException.class));
	}
	public void testcanOnlySignal_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlySignal(module, CTLException.class));
	}
	public void testcanOnlySignal_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.canOnlySignal(module, DAOException.class));
	}
	public void testcanOnlySignal_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, CTLException.class));
	}
	public void testcanOnlySignal_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, DAOException.class));
	}
	public void testcanOnlySignal_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlySignal(module, CTLException.class));
	}
	public void testcanOnlySignal_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, DAOException.class));
	}
	public void testcanOnlySignal_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlySignal(module, CTLException.class));
	}
	public void testcanOnlySignal_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, DAOException.class));
	}
	public void testcanOnlySignal_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlySignal(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES ONLY CAN SIGNAL
	 ********************************************************************************
	 */
	public void testOnlycanSignal_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.onlyCanSignal(module, DAOException.class));
	}
	public void testOnlycanSignal_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.onlyCanSignal(module, CTLException.class));
	}
	public void testOnlycanSignal_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.onlyCanSignal(module, DAOException.class));
	}
	public void testOnlycanSignal_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.onlyCanSignal(module, CTLException.class));
	}
	public void testOnlycanSignal_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, DAOException.class));
	}
	public void testOnlycanSignal_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.onlyCanSignal(module, CTLException.class));
	}
	public void testOnlycanSignal_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, DAOException.class));
	}
	public void testOnlycanSignal_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.onlyCanSignal(module, CTLException.class));
	}
	public void testOnlycanSignal_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, DAOException.class));
	}
	public void testOnlycanSignal_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.onlyCanSignal(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES CANNOT SIGNAL
	 ********************************************************************************
	 */
	public void testcannotSignal_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.cannotSignal(module, DAOException.class));
	}
	public void testcannotSignal_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.cannotSignal(module, CTLException.class));
	}
	public void testcannotSignal_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.cannotSignal(module, DAOException.class));
	}
	public void testcannotSignal_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.cannotSignal(module, CTLException.class));
	}
	public void testcannotSignal_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, DAOException.class));
	}
	public void testcannotSignal_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertTrue(dw.cannotSignal(module, CTLException.class));
	}
	public void testcannotSignal_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, DAOException.class));
	}
	public void testcannotSignal_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertTrue(dw.cannotSignal(module, CTLException.class));
	}
	public void testcannotSignal_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, DAOException.class));
	}
	public void testcannotSignal_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertTrue(dw.cannotSignal(module, CTLException.class));
	}
	/********************************************************************************
	 *						 RULES MUST SIGNAL
	 ********************************************************************************
	 */
	public void testmustSignal_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.mustSignal(module, DAOException.class));
	}
	public void testmustSignal_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.mustSignal(module, CTLException.class));
	}
	public void testmustSignal_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.mustSignal(module, DAOException.class));
	}
	public void testmustSignal_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.mustSignal(module, CTLException.class));
	}
	public void testmustSignal_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, DAOException.class));
	}
	public void testmustSignal_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.mustSignal(module, CTLException.class));
	}
	public void testmustSignal_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, DAOException.class));
	}
	public void testmustSignal_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.mustSignal(module, CTLException.class));
	}
	public void testmustSignal_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, DAOException.class));
	}
	public void testmustSignal_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.mustSignal(module, CTLException.class));
	}
}
