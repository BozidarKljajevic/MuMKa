/***********************************************************************
 * Module:  Observer.java
 * Author:  Bole
 * Purpose: Defines the Interface Observer
 ***********************************************************************/

package observer;

import java.util.*;

/** @pdOid 61fb3165-bbf3-4425-a258-65b1478e63e8 */
public interface Observer {
   /** @param arg0 
    * @param arg1
    * @pdOid 459b2e0d-90cf-464c-8e14-a78f6aac2840 */
    public void update(Observable arg0, Object arg1);

}