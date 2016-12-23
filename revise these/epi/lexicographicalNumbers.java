public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=9 && i<=n; i++){
            stack.push(i);
            while(!stack.isEmpty()){
                int base = stack.pop();
                list.add(base);
                for(int j=9; j>=0; j--){        //pay attention to the order here
                   int next = 10 * base + j;
                   if(next > n) continue;
                   stack.push(next);
                }
            }
        }
        return list;
    }