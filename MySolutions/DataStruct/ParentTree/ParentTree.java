import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;                                                    
import java.util.Queue;
                                                                                
public class ParentTree {                                                       
        public static void main(String[] args) {                                
        	TreeList treeList = new TreeList();
        	TreeHash treeHash = new TreeHash();
        	int result;
        	
        	treeList.buidList(1, 2, 1);
        	treeList.buidList(4, 3, 2);
        	treeList.buidList(2, 4, 3);
        	treeList.buidList(1, 5, 4);
        	treeList.buidList(2, 6, 5);
        	
        	treeHash.buildTree(treeList.getTree());
        	result = treeHash.sumTree(2);
        	System.out.println("Result is: " + result);
        }                                                                       
}                                                                               
                                                                                
class TreeList {                                                                
        private LinkedList<LinkedList<Integer>> tree = new LinkedList();        
                                                                                
        public void buidList(int p, int n, int w) {                                  
                LinkedList<Integer> node = new LinkedList<Integer>();           
                                                                                
                node.add(p);                                                    
                node.add(n);                                                    
                node.add(w);                                                    
                this.tree.add(node);                                            
        }                                                                       
                                                                                
        public LinkedList<LinkedList<Integer>> getTree() {                                           
                return this.tree;                                               
        }                                                                       
}

class TreeHash {                                                                
    private HashMap<Integer, LinkedList<LinkedList<Integer>>> treeHash = new HashMap();          
                                                                            
    public void buildTree(LinkedList<LinkedList<Integer>> treeList) {                            
            //Iterator<LinkedList<Integer>> iter = new treeList.iterate();                        
            for(LinkedList<Integer> node: treeList) {
            	int Id = node.get(1);
            	int pId = node.get(0);
            	
            	if(treeHash.get(pId) != null) {
            		treeHash.get(pId).add(node);
            		System.out.println("1: " + Id);
            	} else {
            		LinkedList<LinkedList<Integer>> hashList_1 = new LinkedList();
            		hashList_1.add(node);
            		treeHash.put(pId, hashList_1);
            		System.out.println("2: " + Id);
            	}
            	
            	if(treeHash.get(Id) == null) {
            		LinkedList<LinkedList<Integer>> hashList_2 = new LinkedList();
            		hashList_2.add(node);
            		treeHash.put(Id, hashList_2);
            		System.out.println("3: " + pId);
            	}
            	// There are some issues with building the hashMap
		// I would prefer to use two hashMap, one to storevalue of the node
		// another to store parent-children relations.
            	// Don;t need to consider the other situation because if the node is
            	// stored in the hashMap, its value should be the same.
            }                                   
            
        	for(int key: treeHash.keySet()) {
        		System.out.println("~~ " + key);
        		System.out.println("**** " + treeHash.get(key).size());
        	}
    }                                                                       
                                                                            
    public int sumTree(int root) {                                          
            //LinkedList<Integer> rootNode = new LinkedList<Integer>();       
            //LinkedList<Integer> pNode = new LinkedList<Integer>();
            //int pId;
            int sum = 0;
            //int subRoot = root;
            ArrayList<Integer> subRoot = new ArrayList<Integer>();
            
            if(treeHash.get(root) == null)
            	return Integer.MIN_VALUE;
            else if(treeHash.get(root).size() == 1)
            	return treeHash.get(root).get(0).get(2);
            
            Queue<LinkedList<LinkedList<Integer>>> queue
            	= new LinkedList<LinkedList<LinkedList<Integer>>>();
            
            System.out.println("Queue is ready");
            
            queue.add(treeHash.get(root));
            subRoot.add(root);
            
            while(!queue.isEmpty()) {
            	LinkedList<LinkedList<Integer>> children = queue.poll();
            	
            	System.out.println("the queue size is: " + queue.size());
            	System.out.println("the subRt size is: " + subRoot.size());
            	
            	for(LinkedList<Integer> node: children) {
            		if(subRoot.size() > 0 && node.get(1) == subRoot.get(0)) {
            			sum += node.get(2);
            			subRoot.remove(0);
            		}
            		else {
            			queue.add(treeHash.get(node.get(1)));
            			subRoot.add(treeHash.get(node.get(1)).getFirst().get(1));
            			System.out.println(treeHash.get(node.get(1)).getFirst().get(1));
            		}
            	}
            }
            
            return sum;
    }                                                                       
}             
