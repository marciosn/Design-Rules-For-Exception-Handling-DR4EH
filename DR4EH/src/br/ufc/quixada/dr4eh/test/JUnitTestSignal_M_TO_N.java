package br.ufc.quixada.dr4eh.test;

import java.io.File;

import br.ufc.quixada.dr4eh.EHDesignWizard;
import br.ufc.quixada.dr4eh.Module;
import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;
import junit.framework.TestCase;

public class JUnitTestSignal_M_TO_N extends TestCase{
	EHDesignWizard dw = new EHDesignWizard("lib" + File.separator + "iContatos.jar");
	private Module module = new Module();
	private Module module2 = new Module();
	
	/*
	 * RULES CANONLYSIGNAL
	 */
	public void testcanOnlySignal_Control_DAO_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlySignal(module, DAOException.class, module2));
	}
	public void testcanOnlySignal_Control_CTL_DAO(){
		module.add("br.ufc.quixada.control");
		module2.add("br.ufc.quixada.dao");
		assertTrue(dw.canOnlySignal(module, CTLException.class, module2));
	}
	/*
	 * RULES ONLYCASIGNAL
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
}
