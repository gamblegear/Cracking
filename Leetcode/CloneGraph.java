/*
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/*
1. (WRONG) build a hashMap to store the neighboring relationship.
2. The hashMap is to map the original node to the cloned new single node, (not
   its neighbors), thus each time a node is visited (may be not from the queue,
   we should set a new entry in the map.)
3. cannot just visit all the nodes and store its neighbor, because according to
   requirement, the neight should be a list of complete nodes. Simply copy the
   neighboring nodes won't contain the neighbors' neighbors. 
*/


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {                                                         
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {           
        if(node == null)                                                        
                return null;                                                    
                                                                                
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();    
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                                                                                
        UndirectedGraphNode head = node;                                        
        queue.add(head);                                                        
                                                                                
        while(!queue.isEmpty()) {                                               
                UndirectedGraphNode n = queue.poll();                        
                                                                                
                if(visited.contains(n))                                      
                        continue;                                               
                visited.add(n);                                              
                                                                                
                UndirectedGraphNode clone;                                      
                if(map.get(n) != null)                                       
                        clone = map.get(node);                                  
                else {                                                          
                        clone = new UndirectedGraphNode(n.label); 
                        map.put(n, clone);                                   
                }                                                               
                
                for(UndirectedGraphNode neighbor: n.neighbors) {             
                        queue.add(neighbor);                                    
                        UndirectedGraphNode neighClone;                         
                                                                                
                        if(map.get(neighbor) == null) {                         
                                neighClone = new UndirectedGraphNode(neighbor.label);
                                map.put(neighbor, neighClone);                  
                        } else                                                  
                                neighClone = map.get(neighbor);                 
                        clone.neighbors.add(neighClone);                        
                }                                                               
        }
        
        return map.get(head);  
    }                                                                           
}  