package com.siyeh.ipp.decls;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiVariable;
import com.intellij.util.IncorrectOperationException;
import com.siyeh.ipp.base.Intention;
import com.siyeh.ipp.base.PsiElementPredicate;

public class SimplifyVariableIntention extends Intention{
    public String getText(){
        return "Replace with Java-style array declaration";
    }

    public String getFamilyName(){
        return "Replace With Java Style Array Declaration";
    }

    public PsiElementPredicate getElementPredicate(){
        return new SimplifyVariablePredicate();
    }

    public void invoke(Project project, Editor editor, PsiFile file)
            throws IncorrectOperationException{
        if(isFileReadOnly(project, file)){
            return;
        }
        final PsiVariable var = (PsiVariable) findMatchingElement(file, editor);
        var.normalizeDeclaration();
    }
}
