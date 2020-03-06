package org.sonar.java.rule.checks.namerules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Rule;
import org.sonar.java.rule.checks.utils.SonarJavaUtils;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;


/**
 * @ClassName LoopsMysqlCheck
 * @Author xcc
 * @Date 2019/11/11 14:36
 * @Desc 嵌套for循环
 **/
@Rule(key="LoopsMysqlCheck")
public class LoopsMysqlCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoopsMysqlCheck.class);
    private JavaFileScannerContext context;
    private StatementTree allTree;

    //TODO 假设查询SQL的方法名为dbQuery
    private String validDB = "dbQuery";

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitForStatement(ForStatementTree tree) {
        LOGGER.info("sql check start");
        StringBuffer expressStatement = new StringBuffer("CODE:\n");
        expressStatement = SonarJavaUtils.getTreeStatementCode(tree, expressStatement);
        LOGGER.info("for 循环  涉及到的 代码:" + expressStatement.toString());
        if (expressStatement.indexOf(validDB) != -1) {
            context.reportIssue(this, tree, "Cant Run mysql in for or forEach");
        }
        super.visitForStatement(tree);
        LOGGER.info("sql check over");
    }
}
