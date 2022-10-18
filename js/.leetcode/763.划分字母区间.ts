/*
 * @lc app=leetcode.cn id=763 lang=typescript
 *ababcbacadefegdehijhklij
 * [763] 划分字母区间
 */

// @lc code=start
function partitionLabels(S: string): number[] {
    let res = new Array<string>()

    let childCheck = (str1: string, str2: string): boolean => {
        for (let i = 0; i < str1.length; i++) {
            for (let j = 0; j < str2.length; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    return false
                }
            }
        }
        return true
    }

    let check = (str: string): boolean => {
        for (let i=0;i<res.length ;i++) {
            if (!childCheck(str, res[i])) {
                return false
            }
        }
        return true
    }

    let helper = (index: number, str: string): boolean => {
        if (index >= S.length) {
            return true
        }
        let newStr = str + S[index]
        console.log(newStr,str,S[index])
        if (check(newStr)) {
            res.push(newStr)
            if (!helper(index + 1, newStr)) {
                res.pop()
                return false
            } else {
                return true
            }
        } else {
            // res.pop()
            return false
        }

    }
    helper(0, "")
    let resCount = new Array<number>()
    res.forEach((item) => {
        console.log(item)
        resCount.push(item.length)
    })
    return resCount
};
// @lc code=end

partitionLabels("ababcbacadefegdehijhklij")