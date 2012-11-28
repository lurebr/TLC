/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Util.Cursor;

/**
 * 
 * @author Lennon
 */
public class CursorFactory {

	private CursorFactory() {
	}

	public static ICursor getCursor() {
		return new CursorAzul();
	}
}
