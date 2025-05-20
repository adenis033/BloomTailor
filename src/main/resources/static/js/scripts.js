// Smooth scrolling for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const targetId = this.getAttribute('href');
        const targetElement = document.querySelector(targetId);
        if (targetElement) {
            window.scrollTo({
                top: targetElement.offsetTop - 80,
                behavior: 'smooth'
            });
        }
    });
});

// Navbar shadow on scroll
window.addEventListener('scroll', function () {
    const navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

// Scroll-based fade-in animation
function handleScrollAnimation() {
    const elements = document.querySelectorAll('.section, .flower-card, .bouquet-card, .store-card, .custom-item');
    const triggerBottom = window.innerHeight * 0.85;

    elements.forEach(el => {
        const boxTop = el.getBoundingClientRect().top;
        if (boxTop < triggerBottom) {
            el.classList.add('animate');
        }
    });
}
window.addEventListener('scroll', handleScrollAnimation);
window.addEventListener('load', handleScrollAnimation);

// Dynamic bouquet price calculator
document.addEventListener('input', function (e) {
    if (e.target.classList.contains('flower-count')) {
        let total = 0;
        document.querySelectorAll('.flower-count').forEach(input => {
            const count = parseInt(input.value) || 0;
            const price = parseFloat(input.dataset.price) || 0;
            total += count * price;
        });
        document.getElementById('custom-price').textContent = '$' + total.toFixed(2);
    }
});
