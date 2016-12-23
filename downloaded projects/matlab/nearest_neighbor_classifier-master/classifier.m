
disp(['Welcome to My Feature Selection Algorithm.'])
filename = input('Type in the name of the file to test:   ');
data = importdata(filename);

reply = input(['Type the number of the algorithm you want to run\n(1) Forward Selection\n(2) Backward Elimination\n(3) My Special Algorithm\n']);

if reply == 1
   forward_search(data);
elseif reply == 2
    backward_elimination(data);
else
     own_algorithm(data);
end