class FormPage {
    get title() {
        return $('android= new UiSelector().resourceId("com.androidsample.generalstore:id/toolbar_title")');
    }

    get nameField() {
        return $('//*[@resource-id="com.androidsample.generalstore:id/nameField"]');
    }

    get femaleRadioBtn() {
        return $('//*[@text="Female"]');
    }

    get countryDropdown() {
        return $('//*[@resource-id="com.androidsample.generalstore:id/spinnerCountry"]');
    }

    get letsShopBtn() {
        return $('//*[@resource-id="com.androidsample.generalstore:id/btnLetsShop"]');
    }

    get toastMessage() {
        return $('//*[@class="android.widget.Toast"]');
    }

    async fillForm(name = 'Sarah Khalid', gender = 'Female', country = 'Brazil') {
        await this.nameField.addValue(name);
        await this.femaleRadioBtn.click();
        await this.countryDropdown.click();
        await $(`android=new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView("${country}")`).click();
    }

    async submitForm() {
        await this.letsShopBtn.click();
    }
}

export default new FormPage();