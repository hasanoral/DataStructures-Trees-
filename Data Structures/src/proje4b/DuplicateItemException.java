/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje4b;

/**
 *
 * @author Hasan-PC
 */
public class DuplicateItemException extends RuntimeException
{
    
    public DuplicateItemException( )
    {
        super( );
    }
    
    public DuplicateItemException( String message )
    {
        super( message );
    }
}
