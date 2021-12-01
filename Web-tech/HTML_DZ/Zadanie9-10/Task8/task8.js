class LinkedListNode {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    prepend(value) {
        const newNode = new LinkedListNode(value, this.head);

        this.head = newNode;

        if (!this.tail) {
            this.tail = newNode;
        }
        return this;
    }

    find(number) {
        if (!this.head) return null

        let currentNode = this.head;

        let count = 0
        while (currentNode && count < number) {
            count++
            currentNode = currentNode.next;
        }
        if (currentNode !== null) {
            return currentNode;
        }
        return "undefined";
    }

    toArray() {
        const nodes = [];

        let currentNode = this.head;

        while (currentNode) {
            nodes.push(currentNode.value);
            currentNode = currentNode.next;
        }
        return nodes;
    }

    toString(callback) {
        return this.toArray()
            .map(node => node.toString(callback))
            .toString();
    }
}

let list = new LinkedList()
list.prepend(10)
list.prepend(5)
list.prepend(16)
list.prepend(25)
list.prepend(32)

console.log(list)
console.log(list.find(0))
console.log(list.toArray())
