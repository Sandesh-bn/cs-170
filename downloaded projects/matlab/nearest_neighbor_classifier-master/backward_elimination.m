%backward elimination: start from a full set and slowly delete instances
function backward_elimination(data);

total_feature_size = size(data, 2)-1; %size of total features
features_not_in = [];

best_over_all = 0;
best_set = [];
weight = ones(total_feature_size, 1);%empty weight array

disp(['The dataset has ',num2str(total_feature_size), ' features(not including the class attribute), with ', num2str(size(data, 1)), ' instances.'])
disp(['Please wait while I normailze the data... Done!'])

accuracy = leave_one_out_cross_validation(data,weight);
accuracy = accuracy * 100;
disp(['Running nearest neighbor with ',num2str(total_feature_size), ' features, and I get ', num2str(accuracy), '%'])
disp(['Beginning Search.'])

for i = 1 : total_feature_size 
    feature_to_add_at_this_level = [];
    best_so_far_accuracy    = 0;    
    
     for k = 1 : total_feature_size 
       if isempty(intersect(features_not_in,k)) % Only consider taking, if not already taken.
            weight(k) = 0;
            accuracy = leave_one_out_cross_validation(data,weight);
            weight(k) = 1;
        if accuracy > best_so_far_accuracy 
            best_so_far_accuracy = accuracy;
            feature_to_add_at_this_level = k;            
        end    
        disp(['If take feature ', num2str(k),' away, get accuracy ', num2str(accuracy*100), '%'])
      end
     end
    
    weight(feature_to_add_at_this_level) = 0;
    features_not_in(i) = feature_to_add_at_this_level;
    current_set_of_features = []; % Initialize an empty set
    %%initialize current set of features using weight for later comparision use
    x = 1;
    for z=1 : total_feature_size
        if(weight(z) ~= 0)
            current_set_of_features(x) = z;
            x = x+1;
        end
    end
    disp(['Feature set ', mat2str(current_set_of_features), ' was the best with accuracy ', num2str(best_so_far_accuracy*100), '%'])
    if best_so_far_accuracy > best_over_all
            best_over_all = best_so_far_accuracy;
            best_set = current_set_of_features;
    end
end 

disp(['Overall the best feature subset is ', mat2str(best_set), ' with accuracy ', num2str(best_over_all*100), '%'])

end

