class CartPage {
    get productNames() {
        return $$('//*[@resource-id="com.androidsample.generalstore:id/productName"]');
    }

    async verifyProductInCart(productName) {
        const items = await this.productNames;
        for (let item of items) {
            if ((await item.getText()) === productName) {
                return true;
            }
        }
        throw new Error(`Product "${productName}" not found in cart`);
    }
}

export default new CartPage();