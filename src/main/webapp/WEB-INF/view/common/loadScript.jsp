<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"></script>
<script>
    window.addEventListener('DOMContentLoaded', event => {

        // Toggle the side navigation
        const sidebarToggle = document.body.querySelector('#sidebarToggle');
        if (sidebarToggle) {
            // Uncomment Below to persist sidebar toggle between refreshes
            // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
            //     document.body.classList.toggle('sb-sidenav-toggled');
            // }
            sidebarToggle.addEventListener('click', event => {
                event.preventDefault();
                document.body.classList.toggle('sb-sidenav-toggled');
                localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
            });
        }

        // Add click event listener to toggle the 'active' class on nav links
        const navLinks = document.querySelectorAll('.nav-link');
        navLinks.forEach(function (link) {
            link.addEventListener('click', function () {
                // Remove 'active' class from all links
                navLinks.forEach(function (navLink) {
                    navLink.classList.remove('active');
                });

                // Add 'active' class to the clicked link
                link.classList.add('active');
            });
        });

        // Preserve active state on page reload (based on the current page URL)
        const currentPath = window.location.pathname;
            navLinks.forEach(function(link) {
                if (link.getAttribute('href') === currentPath) {
                    link.classList.add('active');
                }
        });

        const datatablesSimpleCustom = document.getElementById('datatablesSimpleCustom');
        if (datatablesSimpleCustom) {
            new simpleDatatables.DataTable(datatablesSimpleCustom, {
               perPage: 10,
               perPageSelect: false,
               searchable: false,
               labels: {
                           placeholder: "",  // Optional: Hide search placeholder text
                           perPage: "",      // Optional: Hide "entries per page" label
                           noRows: "No entries found", // Optional: Custom message for no rows
                           info: ""          // Hide the "Showing x to y of z entries" text
                       }
               });
        }

        const datatablesSimple = document.getElementById('datatablesSimple');
        if (datatablesSimple) {
                new simpleDatatables.DataTable(datatablesSimple);
        }

        // Get the dropdown button and menu
        const dropdownToggle = document.querySelector('#navbarDropdown');
        const dropdownMenu = document.querySelector('.dropdown-menu');

        // Ensure the dropdown toggle and menu exist
        if (dropdownToggle && dropdownMenu) {
            // Add click event listener on the dropdown toggle button
            dropdownToggle.addEventListener('click', function(event) {
                event.preventDefault(); // Prevent default anchor behavior

                // Check if the dropdown is already expanded
                const isExpanded = dropdownToggle.getAttribute('aria-expanded') === 'true';

                // Toggle the aria-expanded attribute (accessibility)
                dropdownToggle.setAttribute('aria-expanded', !isExpanded);

                // Toggle the visibility of the dropdown menu
                if (isExpanded) {
                    dropdownMenu.classList.remove('show');
                } else {
                    dropdownMenu.classList.add('show');
                }
            });

            //Close the dropdown when clicking outside
            document.addEventListener('click', function(event) {
                if (!dropdownToggle.contains(event.target) && !dropdownMenu.contains(event.target)) {
                    dropdownMenu.classList.remove('show');
                    dropdownToggle.setAttribute('aria-expanded', 'false');
                }
            });
        }

    });
</script>

