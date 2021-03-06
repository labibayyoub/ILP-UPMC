/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.interfaces.IASTvisitor;
import com.paracamplus.ilp4.interfaces.IASTfieldWrite;

public class ASTfieldWrite extends ASTexpression
implements IASTfieldWrite {

    public ASTfieldWrite (String fieldName,
                          IASTexpression target,
                          IASTexpression value) {
        this.fieldName = fieldName;
        this.target = target;
        this.value = value;
    }
    private final String fieldName;
    private final IASTexpression target;
    private final IASTexpression value;
    
    @Override
	public IASTexpression getTarget() {
        return target;
    }

    @Override
	public String getFieldName() {
        return fieldName;
    }
    
    @Override
	public IASTexpression getValue() {
        return value;
    }

    public <Result, Data, Anomaly extends Throwable> Result 
        accept(IASTvisitor<Result, Data, Anomaly> visitor, Data data)
                throws Anomaly {
        return visitor.visit(this, data);
    }
    
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}
}
