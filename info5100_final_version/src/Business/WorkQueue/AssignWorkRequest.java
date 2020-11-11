/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Dao.CourierOrder;

/**
 *
 * @author llm
 */
public class AssignWorkRequest extends WorkRequest{
   private CourierOrder curOrder;

    public CourierOrder getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(CourierOrder curOrder) {
        this.curOrder = curOrder;
    }
   
}
