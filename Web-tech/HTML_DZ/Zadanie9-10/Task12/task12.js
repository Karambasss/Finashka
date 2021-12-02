age = [77,88,99,22,46,65]
century = [20,21,12,8,16,19]

function arrayCount (arr) {
    let v = 0
    let freqs = new Map();

    for (let i = arr.length; i--; ) {
        v = arr[i];
        if (freqs[v]) {
            freqs[v] = freqs[v] + 1
        }
        else{
            freqs[v] = 1
        }
    }
    return freqs;
}

let age_dict = new Map()

for (let i = 0; i < age.length; i++){
    if (!(century[i] in age_dict)){
        age_dict[century[i]] = age[i]
    }
    else {
        age_dict[century[i]] = age_dict[century[i]] + age[i]
    }
}

count_dict = arrayCount(century)
let sample_century = Object.keys(age_dict)
for (let i = 0; i < Object.keys(age_dict).length; i++){
    age_dict[sample_century[i]] = age_dict[sample_century[i]]/count_dict[sample_century[i]]
}

console.log("ОТВЕТ: ", age_dict)