class BaseError extends Error {
    /**
     * 
     * @param {string} name 
     * @param {string} description 
     */
    constructor(name, description) {
        super(description)

        Object.setPrototypeOf(this, new.target.prototype)
        this.name = name
        Error.captureStackTrace(this)
    }
}

class IllegalBlockTypeError extends BaseError {
    /**
     * 
     * @param {string} name 
     * @param {string} description 
     */
    constructor(name, description) {
        super(name, description);
    }
}
module.exports = {
    BaseError, IllegalBlockTypeError
}