import analyzer.FileAnalyzer;
import analyzer.FunctionAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static List<String> listFilesForFolder(final File folder) {
    List<String> l = new ArrayList<String>();
    File[] files = folder.listFiles();
    if(files != null) {
      for (final File fileEntry : files) {
        if (fileEntry.isDirectory()) {
          l.addAll(listFilesForFolder(fileEntry));
        } else {
          l.add(fileEntry.getAbsolutePath());
        }
      }
    }
    return l;
  }

  public static void main(String[] args){
    String path = "asd";
    String script = "<?php \n" +
      "class TestClass {\n" +
      "\n" +
      "    function __construct() {\n" +
      "        $myFoo = new Foo();\n" +
      "        $this->test(1, array(), $this, new stdClass(), null);\n" +
      "        $myFoo->getInputString();\n" +
      "        $myFoo->inputString = 'bar';\n" +
      "        Bar::add(1, 1);\n" +
      "        self::test(1, array(), $this, new stdClass(), null); \n" +
      "        Test::test(1, array(), $this, new stdClass(), null);\n" +
      "        userDefinedFunction(1, array(), $this, new stdClass(), null); \n" +
      "        time();\n" +
      "    }\n" +
      "\n" +
      "    function test($nix, Array $ar, &$ref, $std, $na, $opt = NULL, $def = \"FooBar\") {\n" +
      "    \t$this->ambiguous();\n" +
      "    }\n" +
      "\n" +
      "    function ambiguous() {\n" +
      "    \t$myBar = new Bar();\n" +
      "\t    $myBar->ambiguous();\n" +
      "    }\n" +
      "\n" +
      "}\n" +
      "\n" +
      "class Foo {\n" +
      "    /**\n" +
      "     * @var string $inputString\n" +
      "     */\n" +
      "    public $inputString = 'test';\n" +
      "    /**\n" +
      "     * @var int $myInteger\n" +
      "     */\n" +
      "    public $myInteger = 20;\n" +
      "    /**\n" +
      "     * @var string[] $stringarray\n" +
      "     */\n" +
      "    public $stringArray = array('1d2','a1d');\n" +
      "    /**\n" +
      "     * @var double $myDouble\n" +
      "     */\n" +
      "    public $myDouble;\n" +
      "\n" +
      "    public function getInputString() {\n" +
      "        return $this->getInputString();\n" +
      "    }\n" +
      "}\n" +
      "\n" +
      "require_once 'Foo.php';\n" +
      "\n" +
      "class Bar {\n" +
      "\n" +
      "    /**\n" +
      "     * @webmethod\n" +
      "     * @return string\n" +
      "     */\n" +
      "    public function sayHello() {\n" +
      "        return 'Hello World!';\n" +
      "    }\n" +
      "\n" +
      "    public function ambiguous() {\n" +
      "\n" +
      "    }   \n" +
      "\n" +
      "    /**\n" +
      "     * @webmethod\n" +
      "     * @param int $x\n" +
      "     * @param int $y\n" +
      "     * @return int\n" +
      "     */\n" +
      "    public function add($x, $y) {\n" +
      "        return $x+$y;\n" +
      "    }\n" +
      "\n" +
      "    /**\n" +
      "     * @webmethod\n" +
      "     * @param float[] $array\n" +
      "     * @return float\n" +
      "     */\n" +
      "    public function arraySum($array) {\n" +
      "      $sum = 0;\n" +
      "      if (is_array($array)) {\n" +
      "        $sum = array_sum($array);\n" +
      "      }\n" +
      "      return $sum;\n" +
      "    }   \n" +
      "  \n" +
      "    /**\n" +
      "     * @webmethod\n" +
      "     * @return Foo\n" +
      "     */\n" +
      "    public function getFoo() {\n" +
      "        $returnValue = new Foo();\n" +
      "\treturn $returnValue;\n" +
      "    }\n" +
      "    \n" +
      "    /**\n" +
      "     * @webmethod\n" +
      "     * @param Foo $inputFoo\n" +
      "     * @return Foo[]\n" +
      "     */\n" +
      "    public function duplicateFoo($inputFoo) {\n" +
      "        $returnValue[] = $inputFoo;\n" +
      "        $returnValue[] = $inputFoo;\n" +
      "\treturn $returnValue;\n" +
      "    }\n" +
      "}\n" +
      "?>";
    File file = new File(path);
    //List<String> fileList = listFilesForFolder(file);
    FileAnalyzer fileAnalyzer = new FileAnalyzer();
    fileAnalyzer.analyze(script);
    System.out.println(fileAnalyzer.getProjectData().toString());

    FunctionAnalyzer functionAnalyzer = new FunctionAnalyzer(fileAnalyzer.getProjectData());
    functionAnalyzer.analyzeAll();
  }
}
