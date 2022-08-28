// Copyright 2022 Akira Kashihara

goog.provide("common.components.Header");
goog.provide("common.components.makeHeader");

goog.require("goog.dom");
goog.require("goog.dom.TagName");

common.components.makeHeader = function (baseDom) {
    const item = new common.components.Header(baseDom);
    item.makeHeaderDom();
    return item;
}

common.components.Header = class {
    constructor(baseDom) {
        this.baseNode = baseDom;
    }

    makeHeaderDom() {
        const newItem = goog.dom.createDom(
            goog.dom.TagName.HEADER,
            null,
            "My Bestラーメンランキング"
        );

        this.baseNode.before(newItem);
    }
}