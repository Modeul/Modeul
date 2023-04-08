<template>
    <div>
        <p id="myElement">Hello, World!</p>
        <button @click="handleClick">Get Element Text</button>
    </div>
</template>
  
<script>
export default {
    methods: {
        handleClick() {
            const element = document.getElementById('myElement');
            console.log(element.textContent);
        }
    }
}
</script>