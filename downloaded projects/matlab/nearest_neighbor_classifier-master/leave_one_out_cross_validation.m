function accuracy = leave_one_out_cross_validation(data, weight)

%%initialize value
total_feature_size = size(data, 2)-1;
total_row_size = size(data, 1);
dist = 0;
best_so_far = 1000;
test_label = 0;
near_label = 0;
success = 0;

%for loop to pick a k to test
for i=1 : total_row_size
    test_label = data(i, 1);
    %for loop to compare and look for nearest neighbor
    for j=1 : total_row_size
        test = 0;
        if(i ~= j) %if not compare with itselt
            for k=1: total_feature_size %go through each feature to calculate distance
               if(weight(k, 1) ~= 0)
                        test = (data(i, k+1) - data(j, k+1))^2; %test_data - neighbor_data square and times weight
                end
                dist = dist + test;
            end
            dist = sqrt(dist);
           
            %if the value is smaller than last neighbor
            if(dist < best_so_far) 
                best_so_far = dist;
                near_label = data(j, 1); %%assign nearest neighbor label to curr 
            end 
            dist = 0;
        end
    end
   
    if (near_label == test_label)
        success = success + 1;
    end
    
    near_label = 0;
    best_so_far=9000;
end
    
     accuracy = success/total_row_size;
end

