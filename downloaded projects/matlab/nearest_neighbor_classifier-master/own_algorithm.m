function own_algorithm(data)
current_set_of_features = []; % Initialize an empty set
total_feature_size = size(data, 2)-1; %size of total features
total_instances = size(data, 1); %size of total instances

instance_to_test = input(['How many instances do you want to test (current total ', num2str(total_instances), '): '])

disp(['The dataset has ',num2str(total_feature_size), ' features(not including the class attribute), with ', num2str(size(data, 1)), ' instances.'])
disp(['Please wait while I normailze the data... Done!'])

weight = ones(total_feature_size);
accuracy = leave_one_out_cross_validation(data,weight);
disp(['Running nearest neighbor with ',num2str(total_feature_size), ' features, and I get ', num2str(accuracy*100), '%'])
disp(['Beginning Search.'])

%initialize anchor
if instance_to_test < total_instances
     test_instances = [];
    s=1;
    while(size(test_instances) < instance_to_test)
        num = randi(total_instances,1,1);
        if isempty(intersect(test_instances, num))
            test_instances(s) = num;
            s = s+1;
        end
    end
    disp(['The instances that we randomly select to test on are: ', mat2str(test_instances)])
else
    for t=1 : total_instances
        test_instances(t) =t;
    end
end

test_instances_size = size(test_instances, 2); 
best_over_all = 0;
best_set = [];
pt = 0;
weight = zeros(total_feature_size);%empty weight array
current_set_of_features =[4, 5]           

for i = 1 : total_feature_size 
    
    feature_to_add_at_this_level = [];
    best_so_far_accuracy    = 0;    
    
     for k = 1 : total_feature_size 
       if isempty(intersect(current_set_of_features,k)) % Only consider adding, if not already added.
           weight(k) = 1;
           accuracy = leave_one_out_cross_validation_own(data,weight, test_instances);
           weight(k) = 0;
        if accuracy > best_so_far_accuracy 
            best_so_far_accuracy = accuracy;
            feature_to_add_at_this_level = k;            
        end    
        
        disp(['Using feature ', num2str(k),' accuracy is ', num2str(accuracy*100), '%'])
      end
     end
    
    current_set_of_features(i) =  feature_to_add_at_this_level;
    weight(feature_to_add_at_this_level) = 1;
    disp(['Feature set ', mat2str(current_set_of_features),' is the best, with accuracy ',num2str(best_so_far_accuracy*100), '%'])
    if best_so_far_accuracy > best_over_all
            best_over_all = best_so_far_accuracy;
            best_set = current_set_of_features;
    else
            disp(['Accuracy did not improve. Continuing search in case of local maxima']) 
    end
end 

disp(['Overall the best set is ', mat2str(best_set), ' with accuracy ', num2str(best_over_all*100), '%'])
end
    