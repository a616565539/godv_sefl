看到题目一个想法就是暴力枚举双层for循环就可以解这题，因为不知道会不会超时，所以就抱着试一试的想法去看看
后面觉得数组的题应该还有会其他方法的解题，于是就用到了HashMap 的形式 采用k为值v为下标，通过减法target-nums[i] 来判断并get出下标
再后面想到数组可以使用双指针的形式，两边移动指向来获取值，再找到对应的下标

# 方法一：暴力枚举
```
public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};
        if(nums.length==2){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
```

# 方法二：HashMap 哈希map
```
public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};
        if(nums.length==2){
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i );
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i])!=null){
                result[0]=i;
                result[1] = map.get(target-nums[i]);
                if(result[0]!=result[1]){
                    break;
                }
            }
        }
        return result;
    }
```
# 方法三：双指针
解题思路：头尾各放一个指针,通过头尾相加的形式去判断是大了还是小了再去移动指针从而达到解题
这里为什么初始化的时候要设置一个-1呢 因为 如果案例是nums=[3,2,3] target=6 这里就会重复赋值就达不到我们想要的效果了 所以只需要赋值一次就好
所以在初始化的时候给与了一个默认值，控制了一下
```
public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        int[] team = Arrays.copyOf(nums, nums.length);
        Arrays.sort(team);
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            if (team[l] + team[r] > target) {
                r--;
                continue;
            }
            if (team[l] + team[r] < target) {
                l++;
                continue;
            }
            if (team[l] + team[r] == target) {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == team[l] && result[0] == -1) {
                result[0] = i;
                continue;
            }
            if (nums[i] == team[r] && result[1] == -1) {
                result[1] = i;
            }
        }
        return result;
    }
```
## 2021.04.24 针对方法二的优化
不进行遍历存储了，直接查找没有就存，这样做的好处是通过先存一个 后面再去查找的时候就找到了，优化了 少了一次遍历
```
public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            //如果存在则返回
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            //不存在则存入
            map.put(nums[i],i);

        }
        return new int[0];

    }
```

