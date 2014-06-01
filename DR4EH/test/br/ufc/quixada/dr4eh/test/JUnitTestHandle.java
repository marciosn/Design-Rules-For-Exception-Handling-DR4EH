package br.ufc.quixada.dr4eh.test;

import java.io.File;

import br.ufc.quixada.dr4eh.DR4EH;
import br.ufc.quixada.dr4eh.Module;
import br.ufc.quixada.exception.CTLException;
import br.ufc.quixada.exception.DAOException;
import junit.framework.TestCase;

public class JUnitTestHandle extends TestCase{
	DR4EH dw = new DR4EH("lib" + File.separator + "iContatos.jar");
	private Module module = new Module();
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
}
