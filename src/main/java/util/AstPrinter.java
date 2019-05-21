package util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import grammar.PhpParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class AstPrinter {
  public AstPrinter() {
  }

  public void print(RuleContext ctx) {
    this.explore(ctx, 0);
  }

  private void explore(RuleContext ctx, int indentation) {
    String ruleName = PhpParser.ruleNames[ctx.getRuleIndex()];

    int i;
    for(i = 0; i < indentation; ++i) {
      System.out.print("  ");
    }

    System.out.println(ruleName + " " + ctx.getText());

    for(i = 0; i < ctx.getChildCount(); ++i) {
      ParseTree element = ctx.getChild(i);
      if (element instanceof RuleContext) {
        this.explore((RuleContext)element, indentation + 1);
      }
    }

  }
}
