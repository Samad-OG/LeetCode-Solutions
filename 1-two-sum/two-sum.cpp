class Solution {
public:
   std:: vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int,int>m;for(int i =0;i<nums.size(); ++i){
            if(m.count(target-nums[i])) return{m[target-nums[i]],i};
            m[nums[i]] =i;
        }
        return {};
    }
};