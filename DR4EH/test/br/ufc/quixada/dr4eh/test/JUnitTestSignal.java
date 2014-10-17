package br.ufc.quixada.dr4eh.test;

import java.io.File;

import junit.framework.TestCase;
import br.ufc.quixada.dr4eh.DR4EH;
import br.ufc.quixada.dr4eh.Module;
import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;


public class JUnitTestSignal extends TestCase{
	DR4EH dw = new DR4EH("lib" + File.separator + "iContatos.jar");
	private Module module = new Module();
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
