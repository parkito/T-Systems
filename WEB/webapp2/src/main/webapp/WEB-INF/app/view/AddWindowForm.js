/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:06
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.view.AddWindowForm', {
    extend: 'Ext.window.Window',
    alias: 'widget.addWindowForm',
    autoShow: true,
    layout: 'fit',
    modal: true,

    items: [
        {
            bodyPadding: 10,
            xtype: 'form',
            items: [
                {
                    xtype: 'textfield',
                    name: 'name',
                    fieldLabel: 'Имя',
                    regex: /^[А-Я-Ё][а-я-ё]{1,}$/,
                    regexText: 'Имя должна состоять из двух и более букв и начинаться с заглавной буквы',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    name: 'phone',
                    fieldLabel: 'Телефон',
                    regex: /^([+][0-9]{11,12})*$/,
                    regexText: 'Телефон должно соответсвовать шаблону "+XXXXXXXXXXX" или "+XXXXXXXXXXXX", где X - цифры. ',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            action: 'save',
            disabled: true
        },
        {
            text: 'Отменить',
            handler: function () {
                this.up('window').close();
            }

        }
    ]
});