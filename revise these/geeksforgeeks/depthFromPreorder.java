

// arguments char array which represents preorder traversal
// tree[i] = 'l' if it is leaf node
// tree[i] = 'n' for internal node
public int findDepth(char tree[], int i){
    if (i >= tree.length || tree[i] == 'l')
        return 0;
    
    i++;
    int left = findDepth(tree, i);
    
    i++;
    int right = findDepth(tree, i);

    return Math.max(left, right) + 1;
}


            n
          /   \
        l       n
               /  \ 
              l     l
        
        return 2


        n
      /   \
     l      n
          /  \
         n     l
       /  \
      l    l

      return 3