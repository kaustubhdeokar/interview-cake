Tree primer.

Three most important questions to me.

Path to a node - preorder traversal recursive. 
    add when encountered
    remove when the children are finished traversing and node is still not found.

LCA - 
    option 1: use above method to find path and find the closest matching node value.
    option 2: four cases 
        2.1 When one of the nodes is the target -> return it, might be a lca.
        2.2 nodes are in different branches -> finding a node where left contains one and right contains one, 
                    that is the LCA!
        2.3 nodes are in same branch -> already found the LCA, propagate that upwards.
        2.4 nothing found -> return null.

Burning a tree - combining path to a node, and then once the node is found,
        then for it's hierarchy, based upon the fact that is it derived from a left or right node, find the max height of the 
        other side, (right for left based and vice versa) and return the max of all those.

        

        

        