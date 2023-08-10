import pyautogui
import time

code_to_type = """
void insert(BinaryTree node, int key){
        if(node==null){
            root=new BinaryTree(key);
            return;
        }
        Queue<BinaryTree> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            node=q.peek();
            q.remove();
            if(node.left==null){
                node.left=new BinaryTree(key);
                break;
            }else
                q.add(node.left);
            if(node.right==null){
                node.right=new BinaryTree(key);
                break;
            }else{
                q.add(node.right);
            }
        }
	}
"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()