import FormPage from '../pageobjects/form.page.js';
import ProductPage from '../pageobjects/product.page.js';
import CartPage from '../pageobjects/cart.page.js';

describe('Ecommerce App Tests', () => {
    it('verifies toast message for missing name', async () => {
        await expect(FormPage.title).toHaveText('General Store');
        await FormPage.femaleRadioBtn.click();
        await FormPage.countryDropdown.click();
        await $('android=new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView("Brazil")').click();
        await FormPage.submitForm();

        const toast = await FormPage.toastMessage;
        await expect(toast).toHaveText('Please enter your name');
    });

    it('fills the form details for shopping', async () => {
        await expect(FormPage.title).toHaveText('General Store');
        await FormPage.fillForm();
        await expect(FormPage.nameField).toHaveText('Sarah Khalid');
        await FormPage.submitForm();
    });

    it('selects a product and adds it to cart', async () => {
        await ProductPage.addProductToCart('Jordan 6 Rings');
        await ProductPage.openCart();
        await CartPage.verifyProductInCart('Jordan 6 Rings');
    });
});