const removeElement = (nums, val) => {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === val) {
            nums.splice(i, 1);
            i--;
        }
    }
    return nums.length;
};

const removeElement = function (nums, val) {
    while (nums.indexOf(val, 0) >= 0) {
        nums.splice(nums.indexOf(val, 0), 1);
    }
    return nums.length;
};