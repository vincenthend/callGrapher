<?php
    class A{
        function bar(){
            return 2;
        }
    }

    class B{
        function bar(){
            return 1;
        }
    }

    class C{
        function __construct(){
            if(true){
                $this->object = new A();
            } else {
                $this->object = new B();
            }
        }

        function foo(){
            return $this->object;
        }
    }

    $obj_c = new C();
    $obj_c->foo($a)->bar();
    doo();
?>