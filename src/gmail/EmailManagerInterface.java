/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author SONTD
 */
public interface EmailManagerInterface {

    public void send(String to, String subject, Object body, Vector<File> filesAttach) throws Exception;

    public void receiv();
}
