package br.ufc.quixada.dr4eh.test;

import java.io.File;

import br.ufc.quixada.dr4eh.EHDesignWizard;
import br.ufc.quixada.dr4eh.Module;
import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;
import junit.framework.TestCase;

public class JUnitTestRaise extends TestCase{
	EHDesignWizard dw = new EHDesignWizard("lib" + File.separator + "iContatos.jar");
	private Module module = new Module();
	
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
	public void testOnlycanRaise_Control_DAO(){
		module.add("br.ufc.quixada.control");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Control_CTL(){
		module.add("br.ufc.quixada.control");
		assertTrue(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Dao_DAO(){
		module.add("br.ufc.quixada.dao");
		assertTrue(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Dao_CTL(){
		module.add("br.ufc.quixada.dao");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Model_DAO(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Model_CTL(){
		module.add("br.ufc.quixada.model");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_View_DAO(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_View_CTL(){
		module.add("br.ufc.quixada.view");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
	public void testOnlycanRaise_Exception_DAO(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyRaise(module, DAOException.class));
	}
	public void testOnlycanRaise_Exception_CTL(){
		module.add("br.ufc.quixada.exception");
		assertFalse(dw.canOnlyRaise(module, CTLException.class));
	}
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
	public void testmustHandle_View_DAO(){
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

}
