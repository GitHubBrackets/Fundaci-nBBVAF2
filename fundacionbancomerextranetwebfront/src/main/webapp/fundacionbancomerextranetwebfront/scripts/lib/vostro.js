var o = olivajs;

var radios = document.querySelectorAll('input[type=radio]');
var forms = document.querySelectorAll('.validate-form');
var errorMessageTxt = 'Por favor llena este campo';
var errorMessageTxtSelector = 'Por favor elige una opci&oacute;n';
var errorMessageTxtTel = 'Por favor ingresa un tel&eacute;fono v&aacute;lido';

/**
 * Busca el padre del nodo indicado que contiene la clase indicada
 * @param {object} nodeElement El objeto DOM al que se le desea encontrar el padre
 * @param {string} className   Nombre de la clase a buscar en el padre
 */
function findParentElementByClass(nodeElement, className) {
    var element = nodeElement;
    while (element) {
        if (element.classList && element.classList.contains(className)) {
            return element;
        }
        element = element.parentNode;
    }
    return null;
}

/**
 * Agrega la funcionalidad de los checkbox para que de forma visual al marcarlo el div padre cambie el color del borde para mostrar una selección
 */
function checkBoxConfirm() {
    var checkboxes = document.querySelectorAll('input[type=checkbox]');
    o.DOMUtils.syncForEach((function (checkbox) {
        if (checkbox.parentElement.getAttribute("class").indexOf("custom-checkbox") === -1) {
            var checkboxWrapper = new o.DOMElement('div');

            if (checkbox.checked) {
                checkboxWrapper.addClasses(['checked']);
            }
            checkboxWrapper.addClasses(['custom-checkbox']);
            checkboxWrapper.renderBefore(checkbox.parentElement, 0);
            checkboxWrapper.getElement().appendChild(checkbox);

            checkboxWrapper.addEvents([{callback: (function () {
                if (!checkbox.disabled) {
                    checkbox.checked = !checkbox.checked;

                    if (checkbox.checked) {
                        checkboxWrapper.addClasses(['checked']);

                        if (findParentElementByClass(checkbox, 'card')) {
                            findParentElementByClass(checkbox, 'card').classList.add('active');
                        }
                    } else {
                        checkboxWrapper.removeClasses(['checked']);
                        if (findParentElementByClass(checkbox, 'card')) {
                            findParentElementByClass(checkbox, 'card').classList.remove('active');
                        }
                    }
                }
            }), name: 'click'}]);
        }
    }), checkboxes);
}

/**
 * Agrega la funcionalidad de validaci&oacute;n a los formularios que contengan la clase 'validate-form'
 */
function requerido () {
    var forms = document.querySelectorAll('.validate-form');
    o.DOMUtils.syncForEach((function (form) {
        var submitButton = form.querySelector('[type=submit]');
        var iputsnumbers = form.querySelectorAll('.intelefono');
        var inputs = form.querySelectorAll('input:not([type=submit]):not(.intelefono), textarea');
        var selects = form.querySelectorAll('select');

        o.DOMUtils.syncForEach((function (input) {
            input.addEventListener('keyup', function(){
            var smallElements = input.parentElement.querySelectorAll('small');
            o.DOMUtils.removeElements(smallElements);
            o.DOMUtils.removeClass(input.parentElement, 'has-error');
            });
        }), inputs);
        
        o.DOMUtils.syncForEach((function (inputn) {
        	inputn.addEventListener('keyup', function(){
            var smallElements = inputn.parentElement.querySelectorAll('small');
            o.DOMUtils.removeElements(smallElements);
            o.DOMUtils.removeClass(inputn.parentElement, 'has-error');
            });
        }), iputsnumbers);

        o.DOMUtils.syncForEach((function(select) {
          if (select) {
            select.addEventListener('change', function() {
              var smallElements = select.parentElement.querySelectorAll(
                'small');

              o.DOMUtils.removeElements(smallElements);
              o.DOMUtils.removeClass(select, 'has-error');
            });
          }
        }), selects);

    submitButton.addEventListener('click', function (event) {
      event.preventDefault();

      o.DOMUtils.syncForEach((function (input) {
        if (!input.classList.contains('intelefono') && input.required && input.value.length === 0) {
          var errorMessage = new o.DOMElement('small');
          if (!input.parentElement.classList.contains('has-error')) {
            o.DOMUtils.addClass(input.parentElement, 'has-error');
            errorMessage.setContent(errorMessageTxt);
            errorMessage.render(input.parentElement);
          }
        }
      }), form.elements);
      
      o.DOMUtils.syncForEach((function (iputsnumber) {
    	  iputsnumber.value = parseInt(iputsnumber.value, 10)+"";
          if (iputsnumber.required && (iputsnumber.value.length === 0 || (typeof iputsnumber.minLength != "undefined" && iputsnumber.value.length < iputsnumber.minLength )||(typeof iputsnumber.maxLength != "undefined" && iputsnumber.value.length > iputsnumber.maxLength ))) {
            var errorMessage = new o.DOMElement('small');
            if (!iputsnumber.parentElement.classList.contains('has-error')) {
              o.DOMUtils.addClass(iputsnumber.parentElement, 'has-error');
              errorMessage.setContent(errorMessageTxtTel);
              errorMessage.render(iputsnumber.parentElement);
            }
          }
        }), iputsnumbers);

        o.DOMUtils.syncForEach((function(select) {
            if (!select.classList.contains('intelefono') && select.required && select.value === '0') {
                var errorMessage = new o.DOMElement('small');

                if (!select.classList.contains('has-error')) {
                  o.DOMUtils.addClass(select, 'has-error');
                  errorMessage.setContent(errorMessageTxtSelector);
                  errorMessage.render(select.parentElement);
                }
            }
      }), form.elements);
    });
  }), forms);
}

window.onload = function () {
    checkBoxConfirm();

    requerido();

  o.DOMUtils.syncForEach((function (radio) {
    var radioWrapper = new o.DOMElement('div');

    if (radio.checked) {
      radioWrapper.addClasses(['checked']);
    }

    radioWrapper.addClasses(['custom-radio']);
    radioWrapper.render(radio.parentElement);
    radioWrapper.getElement().appendChild(radio);

    radioWrapper.addEvents([{
      callback: (function () {
        if (!radio.disabled) {
          radio.checked = !radio.checked;

          if (radio.checked) {
            radioWrapper.addClasses(['checked']);
          } else {
            radioWrapper.removeClasses(['checked']);
          }
        }
      }),
      name: 'click'
    }]);
  }), radios);
};
