const hamburger = document.querySelector('.hamburger');
const menu = document.querySelector('.menuppal');

hamburger.addEventListener('click', () => {
    const isActive = hamburger.classList.toggle('is-active');
    hamburger.setAttribute('aria-expanded', isActive);
    menu.classList.toggle('is_active');
});
