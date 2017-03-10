
page 120/491 in epi

public boolean contains(BTreeNode r, BTreeNode s, BTreNode m){
    BtreeNode curr_r = r, curr_s = s;

    while(curr_r != null && curr_r != s && curr_s != null && curr_s != r){
        if (curr_r == m || curr_s == m)
            return true;
    

        curr_r =curr_r.val > s.data ? curr_r.left:curr_r:right;
        curr_s = curr_s.val > r.data?curr_s.left:curr_s.right;
    }

    while(curr_r != null && curr_r != s){
        if(curr_r == s)
            return true;
    }

curr_r =curr_r.val > s.data ? curr_r.left:curr_r.right;
}