<?php
    class SQLConnector{
        function runQuery($query){
            $selected = $GLOBALS['db'];
            foreach ($children as $node) {
                if ($node->isNew) {
                    continue;
                }
                $paths = $node->getPaths();
                if (isset($node->links['text'])) {
                    $title = isset($node->links['title']) ? '' : $node->links['title'];
                    if ($node->real_name == $selected) {
                        $retval .= ' selected="selected"';
                    }
                    $retval .= '>' . htmlspecialchars($node->real_name);
                }
            }
            $retval .= '</select></form>';
        }
    }
?>