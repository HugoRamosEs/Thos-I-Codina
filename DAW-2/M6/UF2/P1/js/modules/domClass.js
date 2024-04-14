export class DomElement {
    constructor(tag, attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    createElement() {
        if (typeof this.tag === "string" && typeof this.attributes === "object") {
            this.element = document.createElement(this.tag);
            for (let key in this.attributes) {
                let value = this.attributes[key];
                this.element.setAttribute([key], value);
            }
            return this;
        }
    }

    printElement(pos) {
        if (typeof pos === "object") {
            if (Object.keys(pos).length == 2) {
                let parentId;
                let position;
                for (let key in pos) {
                    if (key === "parentId") {
                        parentId = pos[key];
                    } else if (key === "position") {
                        position = pos[key];
                    }
                }
                document.getElementById(parentId).insertAdjacentElement(position, this.element);
            }
            return this;
        }
    }

    deleteElement(){
        this.element.remove();
        return this;
    }

    addListener(action, func) {
        if (typeof action === "string" && typeof func === "function") {
            this.element.addEventListener(action, func);
        }
        return this;
    }

    removeListener(action, func) {
        if (typeof action === "string" && typeof func === "function") {
            this.element.removeEventListener(action, func);
        }
        return this;
    }

    setStyle(styles) {
        if (typeof styles === "object") {
            Object.assign(this.element.style, styles);
        }
        return this;
    }

    innerHTML(html){
        this.element.innerHTML = html;
        return this;
    }
}

export class InlineElement extends DomElement{
    constructor(tag, attributes, text){
        super(tag, attributes);
        this.text = text;
    }

    createElement(){
        super.createElement();
        if (typeof this.text === "string"){
            this.textNode = document.createTextNode(this.text);
            this.element.appendChild(this.textNode);
        }
        return this;
    }

    changeText(text) {
        if (typeof text === "string" && this.textNode) {
            this.textNode.nodeValue = text;
            this.text = text;
        }
    }
}

export class OnlyTagElement extends DomElement{
    constructor(tag, attributes){
        super (tag, attributes);
    }
}

export class CompoundElement extends DomElement{
    constructor(tag, attributes){
        super(tag, attributes);
    }

    addChildren(children){
        if (Array.isArray(children)){
            children.forEach(child => {
                this.element.appendChild(child.element);
            });
        }
        return this;
    }

    deleteChild(child){
        if (child instanceof DomElement) {
            this.element.removeChild(child.element);
        }
    }

    deleteChildren(){
        this.element.innerHTML = "";
    } 
}

export class ElementWithChildren extends DomElement{
    constructor(tag, attributes, children){
        super(tag, attributes);
        this.children = children;
    }

    createElement(){
        super.createElement();
        this.children.forEach(child =>{
            if ("text" in child){
                this.element.appendChild(new InlineElement(child.tag, child.attributes, child.text).createElement().element);
            }else{
                this.element.appendChild(new OnlyTagElement(child.tag, child.attributes).createElement());
            }
        });
        return this;
    }
}

export class SelectElement extends ElementWithChildren {
    constructor(tag, attributes, options) {
        super(tag, attributes, options);
    }
}