// Copyright 2022 Akira Kashihara extends the sample code
//   which is provided by Google.
// The sample code is on
//   https://developers.google.com/closure/library/docs/events_tutorial

goog.provide("ranking.ramen.Item");
goog.provide("ranking.ramen.makeItems");

goog.require("goog.dom");
goog.require("goog.dom.TagName");
goog.require("goog.ui.Zippy");

ranking.ramen.makeItems = function (data, itemsContainer) {
    let items = [];
    for (let i = 0; i < data.length; i++) {
        const item = new ranking.ramen.Item(data[i], itemsContainer);
        items.push(item);
        item.makeItemDom();
    }
    return items;
}

ranking.ramen.Item = class {

    /**
    * @param {Array.<Object>} data. This is filled for the item on the ranking.
    * @param {Element} itemContainer. The item on the ranking will be under this.
    *
    */
    constructor(data, itemContainer) {
        this.ranking = data.ranking;
        this.storeName = data.storeName;
        this.votes = data.votes;
        this.urlImage = data.urlImage;
        this.zipCode = data.zipCode;
        this.address = data.address;
        this.urlMap = data.urlMap;
        this.parentNode = itemContainer;
    }

    /**
    * Create the DOM structure for the item and adds it to the document.
    */
    makeItemDom() {
    console.log("🙀");
    console.log(this.ranking.toString());
        // Ranking text display
        this.rankingElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.ranking.toString()
        );

        // Store name display
        this.storeNameElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.storeName
        )

        // Votes display
        this.votesNumberElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.votes.toString()
        )

        // Item header
        this.headerElement = goog.dom.createDom(
            goog.dom.TagName.DIV,
            null,
            this.rankingElement,
            this.storeNameElement,
            this.votesNumberElement
        )

        // Ramen Image
        this.ramenImageElement = goog.dom.createDom(
            goog.dom.TagName.IMG,
            {src: this.urlImage},
            null
        )

        // Store Name in Content
        this.storeNameInContentElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.storeName
        )

        // Zip number
        this.zipNumberElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.zipCode.toString()
        )

        // Address
        this.addressElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.address
        )

        // urlMap
        this.urlMapElement = goog.dom.createDom(
            goog.dom.TagName.SPAN,
            null,
            this.urlMap
        )

        this.contentContainer = goog.dom.createDom(
            goog.dom.TagName.DIV,
            null,
            this.ramenImageElement,
            this.storeNameInContentElement,
            this.zipNumberElement,
            this.addressElement,
            this.urlMapElement
        )

        let newItem = goog.dom.createDom(
            goog.dom.TagName.DIV,
            null,
            this.headerElement,
            this.contentContainer
        );

        // Add the item to parent node.
        this.parentNode.appendChild(newItem);

        this.zippy = new goog.ui.Zippy(this.headerElement, this.contentContainer);
    }
};