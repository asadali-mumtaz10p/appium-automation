class ProductPage {
    get productNames() {
        return $$('//*[@resource-id="com.androidsample.generalstore:id/productName"]');
    }

    get addToCartButtons() {
        return $$('//*[@resource-id="com.androidsample.generalstore:id/productAddCart"]');
    }

    get cartIcon() {
        return $('//*[@resource-id="com.androidsample.generalstore:id/appbar_btn_cart"]');
    }

    async addProductToCart(productName) {
        await $(`android=new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView("${productName}")`);
        const names = await this.productNames;
        const buttons = await this.addToCartButtons;
        for (let i = 0; i < names.length; i++) {
            const name = await names[i].getText();
            if (name === productName) {
                await buttons[i].click();
                break;
            }
        }
    }

    async openCart() {
        await this.cartIcon.click();
    }
}

export default new ProductPage();