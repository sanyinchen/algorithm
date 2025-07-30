//
// Created by sanyinchen on 7/27/25.
//
struct TupleHash {
    template <typename T>
    size_t operator()(const T& t) const {
        return hash_combine(t);
    }

private:
    // 可递归处理多个字段
    template <typename Tuple, size_t Index = 0>
    static typename enable_if<Index == tuple_size<Tuple>::value, size_t>::type
    hash_combine(const Tuple&) {
        return 0;
    }

    template <typename Tuple, size_t Index = 0>
    static typename enable_if<Index < tuple_size<Tuple>::value, size_t>::type
    hash_combine(const Tuple& t) {
        const size_t current = hash<typename tuple_element<Index, Tuple>::type>()(get<Index>(t));
        const size_t next = hash_combine<Tuple, Index + 1>(t);
        return current ^ (next << 1); // XOR + 位移组合
    }
};

unordered_map<tuple<int, int, int>, bool, TupleHash> memo;