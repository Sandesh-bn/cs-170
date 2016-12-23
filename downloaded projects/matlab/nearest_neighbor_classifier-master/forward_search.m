%%forward search: start from an empty set and slowly add more instances
function forward_selection(data);
current_set_of_features = []; % Initialize an empty set
total_feature_size = size(data, 2)-1; %size of total features

disp(['The dataset has ',num2str(total_feature_size), ' features(not including the class attribute), with ', num2str(size(data, 1)), ' instances.\n'])
disp(['Please wait while I normailze the data... Done!\n'])

weight = ones(total_feature_size);%initialize weight to do the first classification
accuracy = leave_one_out_cross_validation(data,weight);
disp(['Running nearest neighbor with ',num2str(total_feature_size), ' features, using "leave-one-out" evaluation, I get ', num2str(accuracy*100), '% accuracy'])
disp(['Beginning Search.'])
accuracy = 0;

best_over_all = 0;
best_set = [];
weight = zeros(total_feature_size);%empty weight array
           
for i = 1 : total_feature_size
    
    feature_to_add_at_this_level = [];
    best_so_far_accuracy    = 0;    

     for k = 1 : total_feature_size
       if isempty(intersect(current_set_of_features,k)) % Only consider adding, if not already added.
           weight(k) = 1;
           accuracy = leave_one_out_cross_validation(data,weight);
           weight(k) = 0;
        if accuracy > best_so_far_accuracy 
            best_so_far_accuracy = accuracy;
            feature_to_add_at_this_level = k;            
        end    
        disp(['Using feature(s) ', num2str(k),' accuracy is ', num2str(accuracy*100), '%'])
       end
     end

     if(~isempty(feature_to_add_at_this_level))
        current_set_of_features(i) =  feature_to_add_at_this_level;
        weight(feature_to_add_at_this_level) = 1;
        disp(['Feature set ', mat2str(current_set_of_features),' was the best, with accuracy ',num2str(best_so_far_accuracy*100), '%'])
        if best_so_far_accuracy > best_over_all
                best_over_all = best_so_far_accuracy;
                best_set = current_set_of_features;
        else
                disp(['Accuracy did not improve. Continuing search in case of local maxima']) 
        end
     end
end 

disp(['Finiash Search! Overall the best feature subset is ', mat2str(best_set), ' with accuracy ', num2str(best_over_all*100), '%'])

end

