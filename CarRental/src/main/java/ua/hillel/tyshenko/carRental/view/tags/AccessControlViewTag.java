package ua.hillel.tyshenko.carRental.view.tags;

import ua.hillel.tyshenko.carRental.model.Administrator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by roman on 24.09.16.
 */
public class AccessControlViewTag extends TagSupport {
    private Administrator admin;

    public AccessControlViewTag() {
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    public boolean isAccept() {
        return admin != null && admin.getId() != 0;
    }
}
